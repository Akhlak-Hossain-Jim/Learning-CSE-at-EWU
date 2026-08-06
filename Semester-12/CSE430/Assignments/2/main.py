class PasswordChecker:
    def is_strong(self, password):
        if len(password) < 8:
            return False
        if not any(char.isdigit() for char in password):
            return False
        if not any(char.isupper() for char in password):
            return False
        return True


class Cinema:
    def __init__(self, total_seats):
        self.total_seats = total_seats
        self.booked_seats = 0

    def book_seats(self, n):
        if n > self.available_seats():
            raise ValueError("Not enough seats available.")
        self.booked_seats += n

    def available_seats(self):
        return self.total_seats - self.booked_seats

    def is_sold_out(self):
        return self.available_seats() == 0


class InventoryItem:
    def __init__(self, quantity, reorder_level):
        self.quantity = quantity
        self.reorder_level = reorder_level

    def restock(self, amount):
        self.quantity += amount

    def sell(self, amount):
        if amount > self.quantity:
            raise ValueError("Amount exceeds current quantity.")
        self.quantity -= amount

    def needs_reorder(self):
        return self.quantity <= self.reorder_level