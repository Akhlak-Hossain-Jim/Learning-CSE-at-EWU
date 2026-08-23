import time

from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Chrome()

driver.get("https://demoqa.com/text-box")

print("Title :", driver.title)

print("URL :", driver.current_url)

driver.maximize_window()

name = driver.find_element(By.ID, "userName")
name.send_keys("Akhlak Hossain")
print("Value :", name.get_attribute("value"))

email = driver.find_element(By.ID, "userEmail")
email.send_keys("akhlak@akhlak.dev")
print("Value :", email.get_attribute("value"))

address = driver.find_element(By.ID, "currentAddress")
address.send_keys("EWU, Aftab nagar, Dhaka")
print("Value :", address.get_attribute("value"))

submit = driver.find_element(By.ID, "submit")
driver.execute_script("arguments[0].scrollIntoView(true);", submit)
submit.click()

time.sleep(4)

output_name = driver.find_element(By.ID, "name").text
assert "Akhlak Hossain" in output_name, f"'Akhlak Hossain' not found in '{output_name}'"
print("Output Name :", output_name)
print("Assertion passed: name matches.")

driver.quit()

