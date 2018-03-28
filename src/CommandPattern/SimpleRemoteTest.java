package CommandPattern;
//客户端
public class SimpleRemoteTest {
    public static void main(String[] args) {
            SimpleRemoteControl remoteControl = new SimpleRemoteControl();
            Light light = new Light();
            LightOnCommand lightOnCommand = new LightOnCommand(light);

            remoteControl.setSlot(lightOnCommand);
            remoteControl.buttonWasPressed();
        }
}
