team_no = 0
project_choice = 2961

# Convert team_no to 2 bytes
team_no_bytes = team_no.to_bytes(2, byteorder='big')

# Convert project_choice to 2 bytes
project_choice_bytes = project_choice.to_bytes(2, byteorder='big')

print("Team number as 2 bytes:", team_no_bytes)
print("Project choice as 2 bytes:", project_choice_bytes)