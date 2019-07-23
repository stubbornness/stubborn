package com.stubborn.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Slf4j
public class MessageUtils {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    /**
     * Try to resolve the message. Treat as an error if the message can't be found.
     * @param key the code to lookup up, such as 'calculator.noRateSet'
     * @param args an array of arguments that will be filled in for params within
     * the message (params look like "{0}", "{1,date}", "{2,time}" within a message),
     * or {@code null} if none.
     * @return the resolved message
     */
    public static String getMessage(String key, @Nullable Object[] args) {

        try {
            return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            log.warn(e.getMessage());
            return key;
        }
    }

    public static String getMessage(String key) {
        return getMessage(key, null);
    }

    /**
     * Try to resolve the message. Treat as an error if the message can't be found.
     * @param key the code to lookup up, such as 'calculator.noRateSet'
     * @param args an array of arguments that will be filled in for params within
     * the message (params look like "{0}", "{1,date}", "{2,time}" within a message),
     * or {@code null} if none.
     * @param locale the locale in which to do the lookup
     * @return the resolved message
     */
    public static String getMessage(String key, @Nullable Object[] args, Locale locale) {

        try {
            return messageSource.getMessage(key, args, locale);
        } catch (NoSuchMessageException e) {
            log.warn(e.getMessage());
            return key;
        }
    }


    /**
     * Try to resolve the message using all the attributes contained within the
     * {@code MessageSourceResolvable} argument that was passed in.
     * <p>NOTE: We must throw a {@code NoSuchMessageException} on this method
     * since at the time of calling this method we aren't able to determine if the
     * {@code defaultMessage} property of the resolvable is {@code null} or not.
     * @param resolvable the value object storing attributes required to resolve a message
     * @param locale the locale in which to do the lookup
     * @return the resolved message
     */
    public static String getMessage(MessageSourceResolvable resolvable, Locale locale) {
        try {
            return messageSource.getMessage(resolvable, locale);
        } catch (NoSuchMessageException e) {
            log.warn(e.getMessage());
            return resolvable.getDefaultMessage();
        }
    }
}
