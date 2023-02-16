import os
import sys
  
# Checking access with os.F_OK
path1 = os.access("Lab5", os.F_OK)
print("Exists the path:", path1)
  
# Checking access with os.R_OK
path2 = os.access("Lab5", os.R_OK)
print("Access to read the file:", path2)
  
# Checking access with os.W_OK
path3 = os.access("Lab5", os.W_OK)
print("Access to write the file:", path3)
  
# Checking access with os.X_OK
path4 = os.access("Lab5", os.X_OK)
print("Check if path can be executed:", path4)