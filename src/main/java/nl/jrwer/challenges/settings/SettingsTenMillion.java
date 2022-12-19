package nl.jrwer.challenges.settings;

public class SettingsTenMillion implements ISettings {
	private int max = 10000000;
	private int amount = 664579;
	
	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public int getMax() {
		return max;
	}
}
