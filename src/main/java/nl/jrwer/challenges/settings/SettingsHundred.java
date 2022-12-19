package nl.jrwer.challenges.settings;

public class SettingsHundred implements ISettings {
	private int max = 100;
	private int amount = 25;
	
	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public int getMax() {
		return max;
	}
}
