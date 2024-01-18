import os
import pandas as pd

curr_dir = os.getcwd()
datasetinfo_dir = os.path.join(curr_dir,"datasetinfo\\datasetinfo.txt")
with open(datasetinfo_dir, "r") as dataset_file:
    dataset_dir = dataset_file.readline()

#print("dataset directory:", dataset_dir)





