package CommandPattern;
//电灯类
class Light{
    public void on(){}

    public void off(){}
}
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on(); //调用接收者的on方法
    }
}
