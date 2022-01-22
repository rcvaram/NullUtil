package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullUtilsTest {

    @Test
    void trimValueTest() {
        assertEquals("", NullUtils.trimValue(""));
        assertEquals("", NullUtils.trimValue("     "));
        assertEquals("test", NullUtils.trimValue("   test     "));
        assertEquals("test", NullUtils.trimValue("test"));
        assertNull(NullUtils.trimValue(null));
    }

    @Test
    void hasTextTest() {
        assertFalse(NullUtils.hasText(""));
        assertFalse(NullUtils.hasText("     "));
        assertTrue(NullUtils.hasText("   test     "));
        assertTrue(NullUtils.hasText("test"));
        assertFalse(NullUtils.hasText(null));
    }

    @Test
    void executeMutatorTest() {
        MutableTester mutableTester = new MutableTester();
        mutableTester.value = "test";
        NullUtils.executeMutator(mutableTester, (in) -> in.setValue("changed"));
        assertEquals("changed", mutableTester.value);
        MutableTester nullMutableTester = null;
        NullUtils.executeMutator(nullMutableTester, (in) -> in.setValue("changed"));
        assertNull(nullMutableTester);
    }

    public class MutableTester {
        String value;

        public void setValue(String input) {
            value = input;
        }
    }

    @Test
    void executeExecutorOrDefaultTest() {
        assertEquals("test", NullUtils.executeExecutorOrDefault("test   ", String::trim, "defaultValue"));
        assertEquals("test", NullUtils.executeExecutorOrDefault("   test   ", String::trim, "defaultValue"));
        assertEquals("", NullUtils.executeExecutorOrDefault("   ", String::trim, "defaultValue"));
        assertEquals("defaultValue", NullUtils.executeExecutorOrDefault(null, String::trim, "defaultValue"));
    }

    @Test
    void replaceNullTest() {
        assertEquals("test   ", NullUtils.replaceNull("test   ", "defaultValue"));
        assertEquals("   test   ", NullUtils.replaceNull("   test   ", "defaultValue"));
        assertEquals("defaultValue", NullUtils.replaceNull(null, "defaultValue"));
    }
}
