package com.gun.newssearch.demo.services;

import com.gun.newssearch.demo.matchers.RuleSetMatcherHelper;
import com.gun.newssearch.demo.model.News;
import com.gun.newssearch.demo.model.rules.Rule;
import com.gun.newssearch.demo.model.rules.RuleSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsMatcherImpl implements NewsMatcher {
    private Logger logger = LoggerFactory.getLogger(NewsMatcherImpl.class);
    private
    StringNormalizer stringNormalizer;

    @Autowired
    public NewsMatcherImpl(StringNormalizer stringNormalizer) {
        this.stringNormalizer = stringNormalizer;
    }

    @Override
    public boolean match(News news, RuleSet ruleSet) {
        RuleSetMatcherHelper matcherHelper = new RuleSetMatcherHelper();
        boolean checkResult = false;
        for (Rule rule : ruleSet.getRules()) {
            // join title, description, content and normalized
            String normalizedStr = stringNormalizer.normalize(news.getTitle(), news.getDescription(), news.getContent());
            System.out.println(String.format("normalizedStr: %s", normalizedStr));

            checkResult = matcherHelper.add(rule.getKeywords(), normalizedStr)
                    .add(rule.getNewsLang(), news.getLang())
                    .add(rule.getNewsType(), news.getType())
//                    .add(rule.getNewsTags(), news.getTags())
//                    .add(rule.getNewsCategories(), news.getCategories())
                    .check();


            System.out.println(String.format("checkResult: %s", checkResult));
        }
        return checkResult;
    }

}
