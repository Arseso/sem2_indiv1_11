package obj;

public class People {
    public static final int TYPE_FORMAL = 2;
    public static final int TYPE_REAL = 1;
    public static final int TYPE_INFORMAL = 0;

    private String name;
    private int age;
    private int type;

    public People(String name, int age, int type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public void about(){
        System.out.println("���� ����� "+this.name+",��� "+this.age+" ���, � "+typeToString());
    }

    private String typeToString(){
        return switch (this.type) {
            case TYPE_FORMAL -> "���������";
            case TYPE_INFORMAL -> "��������";
            case TYPE_REAL -> "�������";
            default -> "�� ��� �";
        };
    }

    public void hi(People p){
        switch(this.type){
            case TYPE_FORMAL:
                System.out.println(this.name+": ������������, "+ p.getName());
                break;
            case TYPE_INFORMAL:
                System.out.println(this.name+": ������, "+ p.getName());
                break;
            case TYPE_REAL:
                if(this.age+5<p.getAge()) System.out.println(this.name+": ������������, "+ p.getName());
                else System.out.println(this.name+": ������, "+ p.getName());
                break;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getType() {
        return type;
    }
}
