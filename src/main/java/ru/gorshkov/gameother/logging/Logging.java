package ru.gorshkov.gameother.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@Slf4j
public class Logging {
    /** Записывает в файл и консоль информацию о методе, его вызвавшем, и о сообщении */
    public void info(Long id, String methodInfo, String message) {
        log.info(MessageFormat.format("Method ''{0}'', id = {2}: {1}", methodInfo, message, id));
    }

    /** Записывает в файл и консоль информацию о методе, его вызвавшем, и об предупреждении */
    public void warn(Long id, String methodInfo, String message) {
        log.warn(MessageFormat.format("Warning in method ''{0}'', id = {2}: {1}", methodInfo, message, id));
    }

    /** Записывает в файл и консоль информацию о методе, его вызвавшем, и сообщении об ошибке */
    public void error(Long id, String methodInfo, String message) {
        log.error(MessageFormat.format("Error in method ''{0}'', id = {2}: {1}", methodInfo, message, id));
    }

    public void debug(Long id, String methodInfo, String message) {
        log.debug(MessageFormat.format("Method ''{0}'', id = {2}: {1}", methodInfo, message, id));
    }
}
