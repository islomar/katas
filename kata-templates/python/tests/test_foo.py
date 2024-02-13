from expects import equal, expect
from src.foo import Foo


class TestFoo:

    def test_add_two_ints(self) -> None:
        foo = Foo()

        result = foo.add(1, 2)

        expect(result).to(equal(3))
