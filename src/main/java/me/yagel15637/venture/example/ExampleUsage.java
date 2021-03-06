package me.yagel15637.venture.example;

import me.yagel15637.venture.command.AbstractCommand;
import me.yagel15637.venture.command.ICommand;
import me.yagel15637.venture.exceptions.VentureBadArgumentSizeException;
import me.yagel15637.venture.exceptions.VentureException;
import me.yagel15637.venture.manager.CommandManager;

/**
 * @author Reap
 */
public class ExampleUsage {
    public static void main(String[] args) {
        CommandManager.addCommands(new CommandHi(), new CommandSay());
        CommandManager.debug = true;
        CommandManager.parseCommand("hi", "say world", "pls_say world", "say_hi or else");
        // Output: hi hi world world
    }

    public static class CommandHi implements ICommand {
        @Override
        public String[] getAliases() {
            return new String[] {
                    "hi",
                    "say_hi"
            };
        }

        @Override
        public String getDescription() {
            return "says hi";
        }

        @Override
        public String getUsage() {
            return "hi/say_hi";
        }

        @Override
        public void execute(String[] args) throws VentureException {
            if (args.length > 0)
                throw new VentureBadArgumentSizeException("Command Hi requires you to have 0 arguments!");

            System.out.print("hi ");
        }
    }
    public static class CommandSay extends AbstractCommand {
        public CommandSay() {
            super("says whatever you want it to", "say <string...>", "say", "pls_say");
        }

        @Override
        public void execute(String[] args) {
            for (String s : args) {
                System.out.print(s + " ");
            }
        }
    }
}
