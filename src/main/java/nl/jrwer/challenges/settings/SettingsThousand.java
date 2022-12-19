package nl.jrwer.challenges.settings;

public class SettingsThousand implements ISettings {
	private int max = 1000;
	private int amount = 168;
	
	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public int getMax() {
		return max;
	}
}
