import socket
import hashlib
import os

def encode_to_utf8(text):
    return text.encode('utf-8')

def generate_random_nonce():
    # Generate a random 8-byte nonce
    return os.urandom(8)

def calculate_sha256_hash(data):
    # Calculate SHA256 hash of the data
    sha256 = hashlib.sha256()
    sha256.update(data)
    return sha256.digest()

def first_24_bits_are_zero(hash_value):
    # Check if the first 3 bytes (24 bits) of the hash are zero
    return hash_value[:3] == b'\x00\x00\x00'

def send_enroll_register_message(client_socket):
    # Implement sending the ENROLL REGISTER message
    pass

def retry_with_new_nonce():
    # Implement retrying the enrollment process with a new nonce
    pass

def connect_to_server(host, port):
    try:
        # Create a TCP socket
        client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        
        # Connect to the server
        client_socket.connect((host, port))
        
        print("Connected to the server.")
        
        # Receive the ENROLL INIT message
        enroll_init_msg = client_socket.recv(1024)
        
        challenge = enroll_init_msg[-8:]
        
        team_no = 61
        project_choice = 2961
        
        # Convert team_no to 2 bytes
        team_no_bytes = team_no.to_bytes(2, byteorder='big')

        # Convert project_choice to 2 bytes
        project_choice_bytes = project_choice.to_bytes(2, byteorder='big')
        
        # Display the ENROLL INIT message as bytes
        print("Received ENROLL INIT message:", enroll_init_msg)
        
        
        
        email = encode_to_utf8("ahmed.eltawel@tum.de")
        firstname = encode_to_utf8("Ahmed")  # Define these variables
        lastname = encode_to_utf8("Eltawel")   # Define these variables
        username = encode_to_utf8("ahmed.eltawel")   # Define these variables
        nonce = generate_random_nonce()

        encoded_structure = email + b"\r\n" + firstname + b"\r\n" + lastname + b"\r\n" + username
        concatenated_string = challenge + team_no_bytes + project_choice_bytes + nonce + encoded_structure
        
        # size = len(encoded_structure) 
        # print("Byte size of encoded_structure:", size)
        
        
        size = len(concatenated_string) + 4
        print("Byte size of concatenated string:", size)
        
        size = size.to_bytes(2, byteorder='big')
        
        enroll = 681
        enroll = enroll.to_bytes(2, byteorder='big')
        
        print(concatenated_string)
        

        sha256_hash = calculate_sha256_hash(concatenated_string)

        # if first_24_bits_are_zero(sha256_hash):
        #     print("yessss")
        #     # send_enroll_register_message(client_socket)
        # else:
        #     nonce = generate_random_nonce()
        #     concatenated_string = team_no_bytes + project_choice_bytes + challenge + nonce + encoded_structure
        #     sha256_hash = calculate_sha256_hash(concatenated_string)
        #     # retry_with_new_nonce()
            
            
        while not first_24_bits_are_zero(sha256_hash):
            nonce = generate_random_nonce()
            concatenated_string = challenge + team_no_bytes + project_choice_bytes + nonce + encoded_structure
            sha256_hash = calculate_sha256_hash(concatenated_string)

        print("yessss")
        
        concatenated_string = size + enroll + concatenated_string
        
        
        client_socket.sendall(concatenated_string)
        response = client_socket.recv(1024)
        print(response)
        
        # Convert response bytes to bits with space every 8 bits
        response_bits = ""
        for byte in response:
            binary_byte = bin(byte)[2:].zfill(8)  # Remove '0b' prefix and zero-fill to 8 bits
            response_bits += binary_byte + " "
        response_bits = response_bits.rstrip()  # Remove trailing space
        
        print("Response message in bits:", response_bits)

        # Close the connection
        client_socket.close()
        
    except Exception as e:
        print("Error:", e)

if __name__ == "__main__":
    
    host = "p2psec.net.in.tum.de"
    port = 13337
    connect_to_server(host, port)



# Connected to the server.
# Received ENROLL INIT message: b'\x00\x0c\x02\xa8r\xaeSz\x97\x82\xe6\x91'
# Byte size of encoded_structure: 51
# Byte size of concatenated string: 75
# b'r\xaeSz\x97\x82\xe6\x91\x00=\x0b\x91\xae5\xdd0h`q\x0cahmed.eltawel@tum.de\r\nAhmed\r\nEltawel\r\nahmed.eltawel'
# yessss
# b'\x00@\x02\xab\x00\x00\x00\x02Message received after timeout of 10 seconds. Try again.'
# Response message in bits: 00000000 01000000 00000010 10101011 00000000 00000000 00000000 00000010 01001101 01100101 01110011 01110011 01100001 01100111 01100101 00100000 01110010 01100101 01100011 01100101 01101001 01110110 01100101 01100100 00100000 01100001 01100110 01110100 01100101 01110010 00100000 01110100 01101001 01101101 01100101 01101111 01110101 01110100 00100000 01101111 01100110 00100000 00110001 00110000 00100000 01110011 01100101 01100011 01101111 01101110 01100100 01110011 00101110 00100000 01010100 01110010 01111001 00100000 01100001 01100111 01100001 01101001 01101110 00101110
# ibrahimahmed@MacBook-Pro Leetcode workspace % /usr/local/bin/python3 "/Users/ibrahimahmed/Documents/vs projects/Leetcode workspace/p2p.py"
# Connected to the server.
# Received ENROLL INIT message: b'\x00\x0c\x02\xa8(\xe0\xc4G\xae\x9e\xfc\x0e'
# Byte size of concatenated string: 75
# b'(\xe0\xc4G\xae\x9e\xfc\x0e\x00=\x0b\x91\x92\xae\xad\xdf\x8f\x02\xe7\xabahmed.eltawel@tum.de\r\nAhmed\r\nEltawel\r\nahmed.eltawel'
# yessss
# b'\x00\x08\x02\xaa\x00\x00\x00='
# Response message in bits: 00000000 00001000 00000010 10101010 00000000 00000000 00000000 00111101
# ibrahimahmed@MacBook-Pro Leetcode workspace % 