import socket
import pickle
import sys

def client(host = 'localhost', port=8082, message='Primeira mensagem (padrão)', size=0, flag=0):
    # criar socket TCP/IP
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # conectar o socket com o server
    server_address = (host, port)
    print ("Connecting to %s port %s" % server_address)
    print("Quantidade de OBJs por receber: {}" .format(size))
    sock.connect(server_address)
    recv = sys.getsizeof(message) * 2


    # envio de dados
    try:

        print ("Sending %s" % message)

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
