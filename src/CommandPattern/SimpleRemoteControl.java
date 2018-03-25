package CommandPattern;

public class SimpleRemoteControl {
    Command slot;
    public SimpleRemoteControl() {
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }
    public void buttonWasPressed() {
        slot.execute();
    }

    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        remoteControl.setSlot(lightOnCommand);
        remoteControl.buttonWasPressed();
    }
}
