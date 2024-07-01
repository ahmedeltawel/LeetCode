import sys
import time
from selenium import webdriver
from selenium.webdriver.common.by import By

if len(sys.argv) < 2:
    print("Please provide a URL as a command-line argument.")
    sys.exit(1)

siteUrl = sys.argv[1]

# Initialize the WebDriver (make sure you have the appropriate WebDriver for your browser installed)
driver = webdriver.Chrome()  # You can use other browsers by downloading and specifying their WebDriver

# Load the page
driver.get(siteUrl)

# Wait for dynamic content to load (adjust the waiting time as needed)
time.sleep(5)

# Find the playlist URL element
playlist_element = driver.find_element(By.CSS_SELECTOR, "script[src*='MMstartVideos']")

# Extract the playlist URL
playlistUrl = playlist_element.get_attribute("src")

# Close the WebDriver
driver.quit()

print("Playlist URL:", playlistUrl)
