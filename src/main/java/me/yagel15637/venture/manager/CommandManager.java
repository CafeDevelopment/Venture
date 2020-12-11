package me.yagel15637.venture.manager;

import me.yagel15637.venture.command.ICommand;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Reap
 */
public final class CommandManager {
    /**
     * all the commands added
     */
    private static final ArrayList<ICommand> commands = new ArrayList<>();

    /**
     * indicates whether we should use {@link String#equals(Object)} or {@link String#equalsIgnoreCase(String)}
     */
    public static boolean ignoresCases = true;

    /**
     * @return all the commands added
     */
    public static ArrayList<ICommand> getCommands() { return commands; }

    /**
     * adds commands to {@link #commands}
     * @param commands the commands to add
     */
    public static void addCommands(ICommand... commands) { CommandManager.commands.addAll(Arrays.asList(commands)); }

    /**
     * parses the given lines and executes all of them that match the requirements
     * @param lines the lines to parse
     */
    public static void parseCommand(String... lines) {
        for (String line : lines) {
            String[] split = line.split(" ");
            String cmdName = split[0];
            String[] args = Arrays.copyOfRange(split, 1, split.length);

            for (ICommand command : commands) {
                for (String alias : command.getAliases()) {
                    if (ignoresCases ? cmdName.equalsIgnoreCase(alias) : cmdName.equals(alias)) {
                        command.execute(args);
                    }
                }
            }
        }
    }
}
