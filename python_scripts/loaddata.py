import os
import pandas as pd

#CONST VARIABLES
ADDRESS = 0
NAME = 1
COLUMN_NUMS = 2
ROW_NUMS = 3
COLUMNS = 4

class Dataset:
    df = pd.DataFrame()
    metadata = []
    
    def __init__(self, metadata_address):
        self.metadata_address=metadata_address
        with open(self.metadata_address, "r") as metadata_file:
            self.metadata.append(metadata_file.readline())

    def write_dataset_metadata(self):
        with open(self.metadata_address, "w") as file:
            file.writelines("\n".join(map(str, self.metadata)))

    def read_dataset_metadata(self,datasetinfo_dir = "datasetinfo\\datasetinfo.txt"): #returns a list with dataset metadata: metadata_address, name, num columns, num rows, column names.
        with open(datasetinfo_dir,"r") as datasetinfo_file:
            lines = datasetinfo_file.readlines()
        return lines
    
curr_dir = os.getcwd()
datasetmetadata_dir = os.path.join(curr_dir,"datasetinfo\\datasetinfo.txt")

ds = Dataset(datasetmetadata_dir)
print(ds.metadata[0])
ds.df = pd.read_csv(ds.metadata[0])
ds.metadata.append("name:" + ds.metadata[0].split("\\")[-1])
ds.metadata.append("number of columns" + len(ds.df.columns))
ds.metadata.append("number of rows: " + len(ds.df))
ds.metadata.append(ds.df.columns.tolist())
ds.write_dataset_metadata()












