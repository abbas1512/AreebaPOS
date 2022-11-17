package com.areeba.pos.common.LocalHelpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Map;

public class LocaleMessageHelper {

    @Autowired
    private static MessageSource messageSource;

    public LocaleMessageHelper() {
    }

    public static String getMessageByName(String name) {
        try {
            return messageSource.getMessage(name, (Object[])null, LocaleContextHolder.getLocale());
        } catch (Exception var2) {
            return name;
        }
    }

    public static String getMessageByName(String name, @Nullable String... args) {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage(name, args, LocaleContextHolder.getLocale());
        } catch (Exception var3) {
            return name;
        }
    }

    public static <T> T getDbMessage(Map<String, T> map, Class<T> type) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        try {
            T result = map.get(LocaleContextHolder.getLocale().getLanguage());
            if (result == null) {
                result = map.get(Locale.getDefault().getLanguage());
                if (result == null) {
                    result = type.getConstructor().newInstance();
                }
            }

            return type.cast(result);
        } catch (Throwable var3) {
            throw var3;
        }
    }

    public void setMessageSource(MessageSource messageSource) {
        LocaleMessageHelper.messageSource = messageSource;
    }

}
