package com.company.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);

        singleLinkedList.update(new HeroNode(1, "songjiang", "三郎"));
        singleLinkedList.update(new HeroNode(1, "songjiang1", "三郎"));
        singleLinkedList.update(new HeroNode(2, "lujunyi", "zhuren"));

        singleLinkedList.show();

        System.out.println("###################");
        HeroNode heroById = singleLinkedList.getHeroById(2);
        System.out.println(heroById);

        System.out.println("###################");
        singleLinkedList.deleteById(2);

        singleLinkedList.show();
        singleLinkedList.deleteById(3);
        singleLinkedList.show();
        singleLinkedList.deleteById(1);
        singleLinkedList.show();


    }
}

//待头结点的单链表
class SingleLinkedList{
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 根据id删除单链表
     * @param id
     */
    public void deleteById(int id){
        HeroNode p = head;
        while (true){
            if (p.getNext() == null){
                break;
            }
            if (p.getNext().getId() == id){
                if (p.getNext() != null){
                    p.setNext(p.getNext().getNext());
                }else {
                    p.setNext(null);
                }
                break;
            }
            p = p.getNext();
        }
    }

    /**
     * 根据id查找英雄
     * @param id
     * @return
     */
    public HeroNode getHeroById(int id){
        if (head.getNext() == null){
//            System.out.println("空，无法返回！");
            return null;
        }
        HeroNode p = head.getNext();
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
     * 根据编号更新英雄信息
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        HeroNode p = head.getNext();
        while (true){
            if (p == null){
                break;
            }
            if (p.getId() == heroNode.getId()){
                p.setName(heroNode.getName());
                p.setNickName(heroNode.getNickName());
                break;
            }
            p = p.getNext();
        }
    }

    /**
     * 根据英雄排名添加节点
     * 如果当前排名英雄已存在  则添加失败
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode p = head;
        boolean flag = false;      //代表当前节点是否已存在【默认不存在】
        while (true){
            if (p.getNext() == null){
                break;
            }
            if (p.getNext().getId() > heroNode.getId()){
                //找到插入的位置  就在p后边
                break;
            }
            if (p.getNext().getId() == heroNode.getId()){
                //该编号已经存在，插入失败
                flag = true;
                break;
            }
            p = p.getNext();
        }
        if (flag){
            System.out.println("该编号已经存在，插入失败");
        }else {
            heroNode.setNext(p.getNext());
            p.setNext(heroNode);
        }
    }

    /**
     * 遍历单链表
     */
    public void show(){
        if (head.getNext() == null){
            System.out.println("空，无法遍历！");
        }
        HeroNode p = head.getNext();
        while (true){
            if (p == null){
                break;
            }
            System.out.println(p);
            p = p.getNext();
        }
    }

}

class HeroNode{
    private int id;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}
