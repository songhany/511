-module(nov7).
-compile(export_all).

echo() ->
  receive
    {From, Msg} ->
      From!{Msg},
      echo();
    stop ->
      stop
  end.

start() ->
  spawn(?MODULE, echo, []).