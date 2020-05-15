package Part_15;

public class _03_1_DependenceInversionPrincipe {
    public static void main(String[] args) {
        Person1 person = new Person1();
        person.receive(new Email1());
    }
}


class Email1 {
    public String getInfo() {
        return "邮件信息：Hello...";
    }
}

class Person1 {
    public void receive(Email1 email) {
        System.out.println(email.getInfo());
    }
}