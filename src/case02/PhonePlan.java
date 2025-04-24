package case02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

/*
手機方案推薦
輸入通話時間與上網需求 → 推薦方案
輸入欄位：
通話分鐘數（分鐘）
上網流量（GB）

規則例：
通話 > 1000 分鐘 or 流量 > 50 GB → 商務型($1499)
通話 > 500 分鐘 and 流量 > 10 GB → 一般用戶型($660)
流量 < 1 GB and 通話 < 200 分鐘 → 長輩節省型($200)
*/
public class PhonePlan {
	
	private Integer minutes; // 通話分鐘
	private Integer gb; // 流量
	
	// 規則
	static class PlanRule {
		private String type;
		private Integer price;
		private BiPredicate<Integer, Integer> condition;
		
		public PlanRule(String type, Integer price, BiPredicate<Integer, Integer> condition) {
			this.type = type;
			this.price = price;
			this.condition = condition;
		}
		
		public boolean matches(Integer minutes, Integer gb) {
			return condition.test(minutes, gb);
		}
		
		public String getResult() {
			return type + ": $" + price;
		}
		
	}
	
	// 所有規則清單
	private static final List<PlanRule> rules = new ArrayList<>();
	
	// 初始化規則
	static {
		rules.add(new PlanRule("商務型", 1499, (min, gb) -> min > 1000 ||  gb > 50));
		rules.add(new PlanRule("一般用戶型", 660, (min, gb) -> min > 500 &&  gb > 10));
		rules.add(new PlanRule("長輩節省型", 200, (min, gb) -> gb < 1 && min < 20 ));
	}
	
	// 建構子
	public PhonePlan(Integer minutes, Integer gb) {
		this.minutes = minutes;
		this.gb = gb;
	}
	
	// 推薦方案
	public String getPlanRule() {
		return rules.stream()
					.filter(rule -> rule.matches(minutes, gb))
					.findFirst()
					.map(PlanRule::getResult)
					.orElse("無適合方案");
	}
	
	public Integer getMinutes() {
		return minutes;
	}
	
	public Integer getGb() {
		return gb;
	}
}














