package com.company.linkedlist;

//双链表操作
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNodeD heroNodeD1 = new HeroNodeD(1, "宋江", "及时雨");
        HeroNodeD heroNodeD2 = new HeroNodeD(2, "卢俊义", "玉麒麟");
        HeroNodeD heroNodeD3 = new HeroNodeD(3, "吴用", "智多星");

        HeroNodeD heroNodeD4 = new HeroNodeD(4, "公孙胜", "入云龙");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.show();

//        doubleLinkedList.add(heroNodeD2);
//        doubleLinkedList.add(heroNodeD1);
//        doubleLinkedList.add(heroNodeD3);
        doubleLinkedList.addByOrder(heroNodeD3);
        doubleLinkedList.addByOrder(heroNodeD1);
        doubleLinkedList.addByOrder(heroNodeD2);
        doubleLinkedList.addByOrder(heroNodeD4);

        System.out.println(doubleLinkedList.getHeroById(1));

//        System.out.println(doubleLinkedList.delete(4));
        System.out.println("!!!!!!!!!!!!!!");
        doubleLinkedList.show();


        HeroNodeD newHeroNodeD4 = new HeroNodeD(4, "公孙法师", "入云龙1.5");
        doubleLinkedList.update(newHeroNodeD4);
        doubleLinkedList.show();
    }
}

class DoubleLinkedList{
    private HeroNodeD head = new HeroNodeD(0, "", "");

    /**
     * 根据id修改英雄信息
     * @param heroNodeD
     */
    public void update(HeroNodeD heroNodeD){
        HeroNodeD p = head;
        while (true){
            if (p == null){
                break;
            }
            if (p.getId() == heroNodeD.getId()){
                p.setName(heroNodeD.getName());
                p.setNickname(heroNodeD.getNickname());
                return;
            }
            p = p.getNext();
        }
    }

    /**
     * 根据id删除双链表节点
     * @param id
     * @return
     */
    public HeroNodeD delete(int id){
        HeroNodeD p = head;
        while (true){
            if (p.getNext() == null){
                break;
            }
            if (p.getNext().getId() == id){
                //此处删除单链表  删除元素为p的下一个节点、
                HeroNodeD temp = p.getNext();
                if (p.getNext().getNext() != null){
                    p.getNext().getNext().setPre(p);
                    p.setNext(p.getNext().getNext());
                }else {
                    //待删除节点已经没有后续节点
                    p.setNext(null);
                }
                return temp;
            }
            p = p.getNext();
        }
        return null;
    }

    /**
     * 根据id查找英雄
     * @param id
     * @return
     */
    public HeroNodeD getHeroById(int id){
        HeroNodeD p = head.getNext();
        while (true){
            if (p == null){
                break;
            }
            if (p.getId() == id){
                return p;
            }
            p = p.getNext();
        }
        return null;
    }

    /**
     * 按顺序添加英雄  序号冲突则拒绝失败
     * @param heroNodeD
     */
    public void addByOrder(HeroNodeD heroNodeD){
        HeroNodeD p = head;
        boolean flag = false;           //标记是否冲突   【默认不存在】
        while (true){
            if (p.getNext() == null){
                break;
            }
            if (p.getNext().getId() > heroNodeD.getId()){
                break;       //找到插入位置，在p之后添加
            }
            if (p.getNext().getId() == heroNodeD.getId()){
                System.out.println("该英雄已存在，拒绝添加");
                return;
            }
            p = p.getNext();
        }

        if (p.getNext() != null){
            heroNodeD.setNext(p.getNext());
            p.getNext().setPre(p);
            heroNodeD.setPre(p);
            p.setNext(heroNodeD);
        }else {
            p.setNext(heroNodeD);
            heroNodeD.setPre(p);
        }


    }

    /**
     * 添加英雄到单链表的最后
     * @param heroNodeD
     */
    public void add(HeroNodeD heroNodeD){
        HeroNodeD p = head;
        while (true){
            if (p.getNext() == null){
                p.setNext(heroNodeD);
                break;
            }
            p = p.getNext();
        }
    }

    /**
     * 遍历双链表  （从前到后）
     */
    public void show(){
        if (head.getNext() == null){
            System.out.println("双链表为空，无法遍历");
        }else {
            HeroNodeD p = head.getNext();
            while (true){
                if (p == null){
                    break;
                }
                System.out.println(p);
                p = p.getNext();
            }
        }
    }
}

/**
 * 双链表节点
 */
class HeroNodeD{
    private int id;
    private String name;
    private String nickname;

    private HeroNodeD pre;
    private HeroNodeD next;

    public HeroNodeD(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNodeD getPre() {
        return pre;
    }

    public void setPre(HeroNodeD pre) {
        this.pre = pre;
    }

    public HeroNodeD getNext() {
        return next;
    }

    public void setNext(HeroNodeD next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNodeD{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
