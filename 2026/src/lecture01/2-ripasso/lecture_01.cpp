#include "test_vars.cpp"
#include "test_stack_frame.cpp"
#include "test_puntatori.cpp"
#include "test_memoria.cpp"
int main() {
    test_vars();
    test_vars2();
    test_s1();
    test_s2();
    test_stack_frame();
    int r = test_stack_frame_rec();
    test_puntatori();
    test_puntatori2();
    test_mem_static();
    test_mem_dyn();
}