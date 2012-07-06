package models;

public class Command {
	
	private final String name;
	private final String description;
	private String message;

	public Command(String name, String message, String description) {
		this.name = name.trim();
		this.message = message.trim();
		this.description = description.trim();
	}
	
	public String template (String valuesStr) {
		String[] values = valuesStr.split(",");
		String command;
		int c = 0;
		System.out.println("Templating " + this.message + " with " + valuesStr);
		command = this.message;
		while(this.message.indexOf("@") != -1 && c < values.length) {
			//Replace the index character
			command = command.replaceFirst("@", values[c].trim());
			c++;
		}
		return command;
	}
	
	public String toString() {
		return "Command [name=" + name + ", description=" + description
				+ ", message=" + message + "]";
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
}
