package nl.jrwer.challenges.settings;

public class SettingsHundredThousand implements ISettings {
	private int max = 100000;
	private int amount = 9592;
	
	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public int getMax() {
		return max;
	}
}
