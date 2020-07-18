package com.gun.newssearch.demo;

import com.gun.newssearch.demo.model.News;
import com.gun.newssearch.demo.model.rules.AnyMatchConditionImpl;
import com.gun.newssearch.demo.model.rules.KeywordCondition;
import com.gun.newssearch.demo.model.rules.Rule;
import com.gun.newssearch.demo.model.rules.RuleSet;
import com.gun.newssearch.demo.services.NewsMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class NewsMatcherTests {

    @Autowired
    NewsMatcher newsMatcher;

    @Test
    public void happyPathTest() {
        News news = getNews();
        RuleSet ruleSet = createRuleSet(
                "kanada, ilaç , erişim, kanada resmi yayın kuruluşu",
                "tr, de, en",
                "National,Regional");

        boolean matchResult = newsMatcher.match(news, ruleSet);
        assertTrue(matchResult);
    }

    @Test
    public void failWithKeywords() {
        News news = getNews();
        RuleSet ruleSet = createRuleSet("kanada,ilaç, erişim , gungor", null, null);
        assertFalse(newsMatcher.match(news, ruleSet));
    }

    @Test
    public void failWithLang() {
        News news = getNews();
        RuleSet ruleSet = createRuleSet(null, "de", null);
        assertFalse(newsMatcher.match(news, ruleSet));
    }

    @Test
    public void failWithType() {
        News news = getNews();
            RuleSet ruleSet = createRuleSet(null, null, "Regional");
        assertFalse(newsMatcher.match(news, ruleSet));
    }

    private RuleSet createRuleSet(String keywords, String lang, String type) {
        return RuleSet.builder()
                .rules(Arrays.asList(
                        Rule.builder()
                                .keywords(KeywordCondition.builder().value(keywords).build())
                                .newsLang(AnyMatchConditionImpl.builder().value(lang).build())
                                .newsType(AnyMatchConditionImpl.builder().value(type).build())
                                .build()
                ))
                .build();
    }

    private News getNews() {
        return News.builder()
                .title("Kanada'da yeni corona virüs kararı! 31 Temmuz'a kadar uzatıldı")
                .description("Kanada’nın, yeni tip corona virüs (Covid-19) salgını nedeniyle yabancılar için 16 Mart'ta başlattığı ülkeye giriş yasağı 31 Temmuz’a kadar uzatıldı.")
                .content("Kanada Sınır Hizmetleri Ajansı Sözcüsü Rebecca Purdy, Kanada resmi yayın kuruluşu CBC’ye yaptığı açıklamada, \\\"bu gece sona erecek emrin, halk sağlığı nedeniyle 31 Temmuz'a kadar uzatıldığını\\\" belirtti. Purdy, yenilenen emrin Kanada vatandaşı olmayanlar, Kanada’da sürekli oturum izni bulunmayanlar ve daha önce alınan karar metnindeki istisnai durum kapsamına girmeyenleri içine aldığını ifade etti. Resmi makamlara belgeli bildirimde bulunulacak Kararla birlikte Kanada’ya girişine izin verilenlerin 14 gün boyunca kendilerini karantinaya alacaklarına dair hüküm de 31 Ağustos'a kadar uzatıldı. Karantina kararı uyarınca, bu durumda bulunanların Kanada’da karantinada kalacakları uygun bir ev ortamıyla, ilaç ve diğer sağlık hizmetlerine erişim konusunda resmi makamlara belgeli bildirimde bulunmaları gerekiyor. Daha önce yapılan açıklamada, ABD ile olan sınır geçişlerinde zorunlu olmayan seyahat yasakların 21 Temmuz'a kadar uzatıldığı ve bu emir uyarınca, temel işçilerin sınır geçişlerine izin verilmişti.  ")
                .lang("tr")
                .type("National")
                .build();
    }


}
