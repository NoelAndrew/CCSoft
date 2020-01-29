
package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StackTest {

	Stack<Object> stack;

	@Test
	void NewStack() {
		new Stack<>();
	}
	String A1 = "Item";

//Seccion de pruebas para la pila vacia
	class EsVacia {

		//Debe de ejecutarse antes de los metodos
		@BeforeEach
		void NewStack() {
			stack = new Stack<>();
		}
		//Pila Vacia
		@Test
		void isEmpty() {
			assertTrue(stack.isEmpty());
		}
		//Buscamos el elemento A1 en la pila
		@Test
		void SearchItem() {
			assertEquals(A1, stack.search(A1));
		}
		//Devuelve EmptyStackException cuando hacemos pop
		@Test
		void EmptyPop() {
			assertThrows(EmptyStackException.class, stack::pop);
		}

		//devulve EmptyStackException cuando recuperamos el primer elemento de la pila
		@Test
		void EmptyPeek() {
			assertThrows(EmptyStackException.class, stack::peek);
		}

		//Despues de hacer push un elemto
		class AfterPushing {

			//Hacemos push antes de hacer pruebas
			@BeforeEach
			void pushItem() {
				stack.push(A1);
			}
			//Buscamos el elemento A1 en la pila
			@Test
			void SearchItem() {
				assertEquals(A1, stack.search(A1));
			}
			//Pila Vacia
			@Test
			void isEmpty() {
				assertFalse(stack.isEmpty());
			}
			//Regresa el item cuando hacemos pop y esta vacia
			@Test
			void popItem() {
				assertEquals(A1, stack.pop());
			}

			//Regresa el elemento cuando hacemos peek, pero permanece vacio
			@Test
			void peekItem() {
				assertEquals(A1, stack.peek());
			}
		}
	}
}
// end::user_guide[]