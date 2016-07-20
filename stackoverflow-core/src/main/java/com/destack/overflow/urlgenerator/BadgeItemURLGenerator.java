package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.enums.BadgeRetriever;
import com.destack.overflow.initializers.BadgeItemInitializer;

/**
 * @author Deepak
 *
 */
public class BadgeItemURLGenerator extends BaseURLComponentGenerator implements URLGenerator<BadgeItemInitializer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BadgeItemURLGenerator.class);

    @Override
    public URL urlGenerator(BadgeItemInitializer badgeItemInitializer)
            throws MalformedURLException, IllegalAccessException {
        if (badgeItemInitializer != null) {
            String url = "https://api.stackexchange.com/2.2/badges?";
            url += getPageURL(badgeItemInitializer.getPage());
            url += getPageSizeURL((badgeItemInitializer.getPageSize()));
            url += getFromDate((badgeItemInitializer.getFromDate()));
            url += getToDate((badgeItemInitializer.getToDate()));
            if (badgeItemInitializer.getBr().equals(BadgeRetriever.NORMAL)
                    || badgeItemInitializer.getBr().equals(BadgeRetriever.NAME)
                    || badgeItemInitializer.getBr().equals(BadgeRetriever.ID)
                    || badgeItemInitializer.getBr().equals(BadgeRetriever.TAG)) {
                LOGGER.info("Order URL Component");
                url += getOrder(badgeItemInitializer.getOrder());
                LOGGER.info("Badge Sort By URL Component");
                url += getSortURLComponent(badgeItemInitializer.getSort().toString());
                if (badgeItemInitializer.getbMin() != null) {
                    LOGGER.info("Min URL Component");
                    url += getMin(badgeItemInitializer.getbMin().toString());
                }
                if (badgeItemInitializer.getbMax() != null) {
                    LOGGER.info("Max URL Component");
                    url += getMax(badgeItemInitializer.getbMax().toString());
                }
                if (badgeItemInitializer.getBr().equals(BadgeRetriever.NORMAL)
                        || badgeItemInitializer.getBr().equals(BadgeRetriever.NAME)) {
                    if (badgeItemInitializer.getInName() != null
                            && !badgeItemInitializer.getInName().trim().isEmpty()) {
                        LOGGER.info("In Name URL Component");
                        url += getInNameURLComponent(badgeItemInitializer.getInName());
                    }
                }
                url = urlFixer(url);
                url += "&filter=!-*f(6qLMLow-";
                if (badgeItemInitializer.getBr().equals(BadgeRetriever.NORMAL)) {
                    LOGGER.info("Normal BadgeRetriever URL generated");
                    return new URL(url);
                } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.NAME)) {
                    LOGGER.info("Name Based BadgeRetriever URL generated");
                    url = url.replace("badges", "badges/name");
                    return new URL(url);
                } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.ID)
                        && badgeItemInitializer.getBadge_id() != null
                        && !badgeItemInitializer.getBadge_id().isEmpty()) {
                    LOGGER.info("ID Based BadgeRetriever URL generated");
                    url = url.replace("badges",
                            "badges/".concat(String.valueOf(getIdSetURLComponent(badgeItemInitializer.getBadge_id()))));
                    return new URL(url);
                } else if (badgeItemInitializer.getBr().equals(BadgeRetriever.TAG)) {
                    LOGGER.info("Tag Based BadgeRetriever URL generated");
                    url = url.replace("badges", "badges/tags");
                    return new URL(url);
                }
            }
            if (badgeItemInitializer.getBr().equals(BadgeRetriever.RECIPIENT)) {
                LOGGER.info("Recipient Based BadgeRetriever URL generated");
                url = urlFixer(url);
                url += "&filter=!-*f(6qLMLow-";
                url = url.replace("badges?", "badges/recipients?");
                return new URL(url);
            }
            if (badgeItemInitializer.getBr().equals(BadgeRetriever.ID_RECIPIENT)) {
                if (badgeItemInitializer.getBadge_id() != null && !badgeItemInitializer.getBadge_id().isEmpty()) {
                    LOGGER.info("ID Recipient Based BadgeRetriever URL generated");
                    if (!getIdSetURLComponent(badgeItemInitializer.getBadge_id()).isEmpty()) {
                        url = url.replace("badges",
                                "badges/"
                                .concat(String.valueOf(getIdSetURLComponent(badgeItemInitializer.getBadge_id()))
                                        .concat("/recipients")));
                    } else {
                        throw new IllegalArgumentException("IDs are mandatory");
                    }
                } else {
                    throw new IllegalArgumentException("IDs are mandatory");
                }
                url = urlFixer(url);
                url += "&filter=!-*f(6qLMLow-";
                return new URL(url);
            }
        }
        throw new InvalidParameterException("Invalid arguments passed");
    }

}
