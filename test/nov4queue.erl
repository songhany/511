-module(nov4queue).
-compile(export_all).

q1() ->
    queue:in(1, queue:in(2, queue:in(3, queue:new()))).

sizeq(Q) ->
    case queue:out(Q) of 
      {empty, _} ->
          0;
      {{value, _}, Rest} ->
          1 + sizeq(Rest)
    end.