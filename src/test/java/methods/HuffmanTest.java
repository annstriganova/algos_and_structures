package methods;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HuffmanTest {

    private Huffman huffman;

    @BeforeAll
    void setUp() {
        huffman = new Huffman();
    }

    @Test
    void encode() {
        StringBuilder result = huffman.encode("abacabad");
        assertEquals("01001100100111", result.toString());
        Map<String, Huffman.Node> leaves = huffman.leaves;
        assertEquals(4, leaves.size());
    }

    @Test
    void decode() {
        Map<String, String> codes = new HashMap<>();
        codes.put("a", "0");
        codes.put("b", "10");
        codes.put("c", "110");
        codes.put("d", "111");
        StringBuilder result = huffman.decode(codes, "01001100100111");
        assertEquals("abacabad", result.toString());
     }
}