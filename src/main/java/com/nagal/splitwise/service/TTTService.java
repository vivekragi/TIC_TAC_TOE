package com.nagal.splitwise.service;

import com.nagal.splitwise.models.Board;
import com.nagal.splitwise.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TTTService {

	@Autowired
	Board board;

	public Boolean validMove(int x,int y){
		if(x<1 || x> board.getSize()|| y<1 || y>board.getSize()) return false;
		if(board.getLocation().get(x-1).get(y-1)=='O' || board.getLocation().get(x-1).get(y-1)=='X') return false;
		return true;
	}

	public void playMove(int x,int y) {
		if(!validMove(x,y)) {
			System.out.printf("Your input %d  %d was invalid please re enter valid choice to play \n", x, y);
			return;
		}
		System.out.printf("move is %d\n",board.getMoveNumber());
		if(board.getMoveNumber()%2==0) board.getLocation().get(x-1).set(y-1,'O');
		else board.getLocation().get(x-1).set(y-1,'X');
		board.incMoveNumber();
		return;
	}

	public  List<List <Character>> getState() {
		return board.getLocation();
	}

	public String isFinished(){

		int countD1=0; // +1 for X , -1 for O;
		int countD2=0; // +1 for X , -1 for O;
		int flag = 0;
		for (int i=0;i<board.getSize();i++){
			int countO=0;
			int countX=0;
			int columnO=0;
			int columnX=0;

			for (int j=0;j<board.getSize();j++) {
				char ch=board.getLocation().get(i).get(j);
				char chColumn=board.getLocation().get(j).get(i);

				if(ch=='O') countO++;
				else if(ch=='X') countX++;

				if(chColumn=='O') columnO++;
				else if(chColumn=='X') columnX++;

				if(i==j){
					if(ch=='O') countD1--;
					if(ch=='X') countD1++;
				}

				if(i+j==board.getSize()+1) {
					if (ch == 'O') countD2--;
					if (ch == 'X') countD2++;
				}
			}

			if(countX==board.getSize() || countD2==board.getSize() || countD1==board.getSize() || columnX==board.getSize()){
				System.out.printf("won by %s \n",board.getUser1().getUsername());
				return board.getUser1().getUsername();
			}
			if(columnO==board.getSize() || countO==board.getSize() || countD2==-1*board.getSize() || countD1==-1*board.getSize() ) {
				System.out.printf("won by %s \n",board.getUser2().getUsername());
				return board.getUser2().getUsername();
			}

		}
		return null;

	}

}
