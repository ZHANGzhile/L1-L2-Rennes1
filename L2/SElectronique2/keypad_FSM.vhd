
architecture RTL of keypad_FSM is --851420447
	
	function BOOL_TO_SL(X : boolean)
              return std_logic is
	begin
	  if X then
	    return '1';
	  else
	    return '0';
	  end if;
	end BOOL_TO_SL;
	
	type state_type is (S_E0,S_E1,S_E2,S_E3,S_E4,S_E5,S_E6,S_E7,S_E8,S_E9,S_S10,S_E11,S_E12,S_E13);  
	signal symCS : state_type ;  
	signal CS : std_logic_vector(3 downto 0) ;  
	
	constant ONE : std_logic:='1';
	constant ZERO : std_logic:='0';

	constant E0 : std_logic_vector(3 downto 0):="0000";
	constant E1 : std_logic_vector(3 downto 0):="0001";
	constant E2 : std_logic_vector(3 downto 0):="0010";
	constant E3 : std_logic_vector(3 downto 0):="0011";
	constant E4 : std_logic_vector(3 downto 0):="0100";
	constant E5 : std_logic_vector(3 downto 0):="0101";
	constant E6 : std_logic_vector(3 downto 0):="0110";
	constant E7 : std_logic_vector(3 downto 0):="0111";
	constant E8 : std_logic_vector(3 downto 0):="1000";
	constant E9 : std_logic_vector(3 downto 0):="1001";
	constant S10 : std_logic_vector(3 downto 0):="1010";
	constant E11 : std_logic_vector(3 downto 0):="1011";
	constant E12 : std_logic_vector(3 downto 0):="1100";
	constant E13 : std_logic_vector(3 downto 0):="1101";
	
begin
	UPDATE: process(clk,rst)
	begin
		if rst='1' then
			CS <= E0;
			symCS <= S_E0;
		elsif rising_edge(clk) then
			if en='1'then
				case (CS) is
					when E0 =>
									-- default transition
									CS <= E1;
									symCS <= S_E1;
					when E1 =>
									if BOOL_TO_SL(lhit=ZERO)='1'  then
										CS <= E2;
										symCS <= S_E2;
									end if;
									if BOOL_TO_SL(lhit=ONE)='1'  then
										CS <= E5;
										symCS <= S_E5;
									end if;
					when E2 =>
									if BOOL_TO_SL(lhit=ZERO)='1'  then
										CS <= E3;
										symCS <= S_E3;
									end if;
									if BOOL_TO_SL(lhit=ONE)='1'  then
										CS <= E6;
										symCS <= S_E6;
									end if;
					when E3 =>
									if BOOL_TO_SL(lhit=ZERO)='1'  then
										CS <= E4;
										symCS <= S_E4;
									end if;
									if BOOL_TO_SL(lhit=ONE)='1'  then
										CS <= E7;
										symCS <= S_E7;
									end if;
					when E4 =>
									if BOOL_TO_SL(lhit=ONE)='1'  then
										CS <= E8;
										symCS <= S_E8;
									end if;
					when E5 =>
									if BOOL_TO_SL(ACK=ONE)='1'  then
										CS <= E9;
										symCS <= S_E9;
									end if;
					when E6 =>
									if BOOL_TO_SL(ACK=ONE)='1'  then
										CS <= S10;
										symCS <= S_S10;
									end if;
					when E7 =>
									if BOOL_TO_SL(ACK=ONE)='1'  then
										CS <= E11;
										symCS <= S_E11;
									end if;
					when E8 =>
									if BOOL_TO_SL(ACK=ONE)='1'  then
										CS <= E12;
										symCS <= S_E12;
									end if;
					when E9 =>
									if (BOOL_TO_SL(ACK=ZERO) and BOOL_TO_SL(lhit=ZERO))='1'  then
										CS <= E13;
										symCS <= S_E13;
									end if;
					when S10 =>
									if (BOOL_TO_SL(ACK=ZERO) and BOOL_TO_SL(lhit=ZERO))='1'  then
										CS <= E13;
										symCS <= S_E13;
									end if;
					when E11 =>
									if (BOOL_TO_SL(ACK=ZERO) and BOOL_TO_SL(lhit=ZERO))='1'  then
										CS <= E13;
										symCS <= S_E13;
									end if;
					when E12 =>
									if (BOOL_TO_SL(ACK=ZERO) and BOOL_TO_SL(lhit=ZERO))='1'  then
										CS <= E13;
										symCS <= S_E13;
									end if;
					when E13 =>
									if BOOL_TO_SL(ACK=ZERO)='1'  then
										CS <= E1;
										symCS <= S_E1;
									end if;
					when others => null;
				end case; 
			end if;
		end if;
	end process;
	
	OUTPUT : process(CS,lhit,ACK)
	begin
		C <= "0000";WE <= '0';REQ <= '0'; 
		case (CS) is
			when E0 => null;
			when E1 => 
			C<="0001";
			WE<=ZERO;
			REQ<=ZERO;
			when E2 => 
			C<="0010";
			WE<=ZERO;
			REQ<=ZERO;
			when E3 => 
			C<="0100";
			WE<=ZERO;
			REQ<=ZERO;
			when E4 => 
			C<="1000";
			WE<=ZERO;
			REQ<=ZERO;
			when E5 => 
			C<="0001";
			WE<=ONE;
			REQ<=ONE;
			when E6 => 
			C<="0010";
			WE<=ONE;
			REQ<=ONE;
			when E7 => 
			C<="0100";
			WE<=ONE;
			REQ<=ONE;
			when E8 => 
			C<="1000";
			WE<=ONE;
			REQ<=ONE;
			when E9 => 
			C<="0001";
			WE<=ZERO;
			REQ<=ONE;
			when S10 => 
			C<="0010";
			WE<=ZERO;
			REQ<=ONE;
			when E11 => 
			C<="0100";
			WE<=ZERO;
			REQ<=ONE;
			when E12 => 
			C<="1000";
			WE<=ZERO;
			REQ<=ONE;
			when E13 => 
			C<="0000";
			WE<=ZERO;
			REQ<=ZERO;
			when others => null;
		end case; 
	end process;
	
end RTL;
