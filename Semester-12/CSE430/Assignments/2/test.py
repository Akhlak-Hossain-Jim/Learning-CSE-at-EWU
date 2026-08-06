import pytest
from main import PasswordChecker, Cinema, InventoryItem

@pytest.fixture
def checker_fixture():
    return PasswordChecker()

@pytest.mark.parametrize(
    "password, expected",
    [
        ("StrongPass1", True),
        ("Short1A", False),
        ("nodigitpassA", False),
        ("nouppercase1", False),
        ("", False)
    ]
)
def test_password_strength(checker_fixture, password, expected):
    assert checker_fixture.is_strong(password) == expected

def test_normal_booking():
    cinema = Cinema(10)
    cinema.book_seats(4)
    assert cinema.available_seats() == 6
    assert cinema.is_sold_out() == False

def test_exact_sellout():
    cinema = Cinema(5)
    cinema.book_seats(5)
    assert cinema.available_seats() == 0
    assert cinema.is_sold_out() == True

def test_overbooking_attempt():
    cinema = Cinema(10)
    with pytest.raises(ValueError) as excinfo:
        cinema.book_seats(12)
    assert str(excinfo.value) == "Not enough seats available."

def test_booking_zero_seats():
    cinema = Cinema(10)
    cinema.book_seats(0)
    assert cinema.available_seats() == 10
    assert cinema.is_sold_out() == False

def test_sequential_bookings():
    cinema = Cinema(15)
    cinema.book_seats(5)
    cinema.book_seats(5)
    assert cinema.available_seats() == 5
    assert cinema.is_sold_out() == False

def test_sell_exceeds_quantity_raises_value_error():
    item = InventoryItem(quantity=10, reorder_level=5)
    with pytest.raises(ValueError) as excinfo:
        item.sell(15)
    assert str(excinfo.value) == "Amount exceeds current quantity."

def test_needs_reorder_returns_true_at_or_below_level():
    item = InventoryItem(quantity=6, reorder_level=5)
    assert item.needs_reorder() == False
    item.sell(1) # drops exactly to reorder level
    assert item.needs_reorder() == True
    item.sell(2) # drops below reorder level
    assert item.needs_reorder() == True

@pytest.mark.parametrize(
    "initial_qty, reorder_lvl, restock_amt, sell_amt, expected_qty",
    [
        (10, 5, 5, 2, 13),
        (0, 5, 20, 20, 0),
        (50, 10, 0, 10, 40)
    ]
)
def test_restock_and_sell_combinations_update_quantity(initial_qty, reorder_lvl, restock_amt, sell_amt, expected_qty):
    item = InventoryItem(initial_qty, reorder_lvl)
    item.restock(restock_amt)
    item.sell(sell_amt)
    assert item.quantity == expected_qty