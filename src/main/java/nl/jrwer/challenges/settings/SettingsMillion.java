package nl.jrwer.challenges.settings;

public class SettingsMillion implements ISettings {
	private int max = 1000000;
	private int amount = 78498;
	
	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public int getMax() {
		return max;
	}
}
