package Part_15;

public class _03_2_DependenceInversionPrincipe {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}

interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {

    @Override
    public String getInfo() {
        return "邮件信息：Hello...";
    }
}

class WeChat implements IReceiver {

    @Override
    public String getInfo() {
        return "微信消息：Hi...";
    }
}


class Person {
    // receive 依赖了接口 IReceiver
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
