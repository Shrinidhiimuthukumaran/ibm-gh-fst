import getpass

def play_round():
    moves = ['rock', 'paper', 'scissors']
    
    print("--- Player 1 ---")
    p1 = getpass.getpass("Enter move (rock, paper, or scissors): ").lower()
    
    print("--- Player 2 ---")
    p2 = getpass.getpass("Enter move (rock, paper, or scissors): ").lower()
    
    print(f"\nRevealing moves! P1: {p1} | P2: {p2}")
    
    if p1 not in moves or p2 not in moves:
        print("Invalid move")
        return

    if p1 == p2:
        print("It's a tie!")
    elif (p1 == 'rock' and p2 == 'scissors') or (p1 == 'paper' and p2 == 'rock') or (p1 == 'scissors' and p2 == 'paper'):
        print("Player 1 wins!")
    else:
        print("Player 2 wins!")


play_round()
