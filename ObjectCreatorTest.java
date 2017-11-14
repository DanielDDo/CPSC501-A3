import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObjectCreatorTest {

	@Test
	void testObjectCreator1Default() {
		ObjectCreator anOC = new ObjectCreator();
		Class1 obj = anOC.createObject1();
		
		assertEquals(false, obj.isPrim1());
		assertEquals(' ', obj.getPrim2());
		assertEquals(-1, obj.getPrim3());
	}

}
