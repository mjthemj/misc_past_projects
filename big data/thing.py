



picksave_tuple = [("ID", "Name", "Price", "Size")]
picknsave_list = [picksave_tuple]


for i in range (1, 12):
  #print(i)
  this_url = url + str(i) + "&pzn=relevance"
  returned_list2 = picknsave_function(this_url, headers)
  for j in range (0, len(returned_list2)):
    picknsave_list.append(returned_list2[j])
#print(picknsave_list)

csv_pickn = "picknsave.csv"

with open(csv_walmart, "w", newline="") as csv_file:
  csv_writer = csv.writer(csv_file)
  for row in walmart_list:
    csv_writer.writerow(row)

with open(csv_pickn, "w", newline="") as csv_file:
  csv_writer = csv.writer(csv_file)
  for row in picknsave_list:
    csv_writer.writerow(row)