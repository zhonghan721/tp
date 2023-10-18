package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
        + "Example: " + COMMAND_WORD;

    // public static final String SHOWING_HELP_MESSAGE = "Opened help window.";
    // Give a more informative help message that explains how to use basic commands
    public static final String HELP_MESSAGE = "Ensure you have registered an account / have logged"
        + " in before using the following basic commands.\n\nRefer to the URL in the pop-up window for"
        + " our full user guide.\n"
        + "\t1. register: Registers a new account.\n"
        + "\t2. login: Logs in to an existing account.\n"
        + "\t3. logout: Logs out of the current account.\n"
        + "\t4. help: Shows program usage instructions.\n"
        + "\t5. exit: Exits the program.\n"
        + "\t6. clear: Clears the screen.\n\n"

        + "The following commands can be used after logging in.\n"
        + "\tFor customers:\n"
        + "\t1. customer list: Lists all customers.\n"
        + "\t2. customer add: Adds a customer.\n"
        + "\t3. customer delete: Deletes a customer.\n"
        + "\t4. customer edit: Edits a customer.\n\n"

        + "\tFor deliveries:\n"
        + "\t1. delivery status: Lists all deliveries.\n\n\n"
        + "More commands will be added in the future.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(HELP_MESSAGE, true, false, false);
    }
}
