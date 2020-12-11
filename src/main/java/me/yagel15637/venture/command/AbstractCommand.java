package me.yagel15637.venture.command;

/**
 * overrides {@link ICommand} so you can make a command with parameters and only override {@link #execute(String[])}
 * @author Reap
 */
public abstract class AbstractCommand implements ICommand {
    private final String[] aliases;
    private final String description, usage;

    public AbstractCommand(String description, String usage, String... aliases) {
        this.aliases = aliases;
        this.description = description;
        this.usage = usage;
    }

    @Override public String[] getAliases() { return aliases; }
    @Override public String getDescription() { return description; }
    @Override public String getUsage() { return usage; }
}
