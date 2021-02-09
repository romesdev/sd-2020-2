import socket
import pickle
import sys

def client(host = 'localhost', port=8082, message='', size=0, flag=0):
    # Create a TCP/IP socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # Connect the socket to the server
    server_address = (host, port)
    print ("Connecting to %s port %s" % server_address)
    print("Quantidade de OBJs por receber: {}" .format(size))
    sock.connect(server_address)
    recv = sys.getsizeof(message) * 2
    """
     if(flag == 1):
        recv = message._bytes()
        print(recv)
        message = pickle.loads(message)
    """

    # Send data
    try:

        print ("Sending %s" % message)
        #sock.sendall(message.encode('utf-8'))
        # Look for the response
        #amount_received = 0
        #amount_expected = len(message)
        """
         while amount_received < amount_expected:
            data = sock.recv(48)
            amount_received += len(data)
            print ("Received: %s" % data)
        """
        data_string = pickle.dumps(message)
        sock.send(data_string)

        data = sock.recv(recv)
    except socket.error as e:
        print ("Socket error: %s" %str(e))
    except Exception as e:
        print ("Other exception: %s" %str(e))
    finally:
        data_load = pickle.loads(data)
        print('Received', repr(data_load))
        print ("Closing connection to the server")
        sock.close()

client()
