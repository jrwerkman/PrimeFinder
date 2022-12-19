package nl.jrwer.challenges.settings;

public class SettingsBillion implements ISettings {
	private int max = 1000000000;
	private int amount = 50847534;
	
	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public int getMax() {
		return max;
	}
}
