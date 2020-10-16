package org.api.design.chapter7;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lili
 * @date 2020/7/26 19:14
 * @notes
 */
public final class Launcher {
    private static Class<? extends WordLibrary> wordLibrary;
    private static Class<? extends Scrambler> scrambler;
    private static Class<? extends UI> ui;


    private static Map<Class<?>, Object[]> instances = new LinkedHashMap<>();

    public static void register(Class<?> impl) {
        instances.put(impl, new Object[1]);
    }

    public static <T> T find(Class<T> whatType) {
        for (Map.Entry<Class<?>, Object[]> entry : instances.entrySet()) {
            if (whatType.isAssignableFrom(entry.getKey())) {
                try {
                    entry.getValue()[0] = entry.getKey().newInstance();
                } catch (Exception ex) {
                    throw new IllegalStateException(ex);
                }
            }
            return whatType.cast(entry.getValue()[0]);
        }
        return null;
    }


    public static void registerWordLibrary(Class<? extends WordLibrary> libraryClass) {
        wordLibrary = libraryClass;
    }

    public static void registerUI(Class<? extends UI> uiClass) {
        ui = uiClass;
    }

    public static void registerScrambler(Class<? extends Scrambler> scramblerClass) {
        scrambler = scramblerClass;
    }

    public static UI launch() throws Exception {
        WordLibrary w = wordLibrary.newInstance();
        Scrambler s = scrambler.newInstance();
        return ui.getConstructor(WordLibrary.class, Scrambler.class).newInstance(w, s);
    }


}
