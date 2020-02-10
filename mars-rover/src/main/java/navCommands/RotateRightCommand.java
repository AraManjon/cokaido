package navCommands;

import position.Rover;

public class RotateRightCommand extends Command {

    protected RotateRightCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void execute() {
        rover.rotateRight();
    }
}
