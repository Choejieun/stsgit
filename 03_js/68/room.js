/*
    roomName 방이름
    desc 방설명
    id 방 고유 id ex.1000 1001 ...
    e 동쪽 방의 고유 id (0이면 동쪽으로 연결이 안된 방, 특정id값이면 해당id방과 연결되었다는 뜻)
    w 서 //
    s 남 //
    n 북 //
    u 위 //
    d 밑 //
*/
function Room(roomName, desc, id, e, w, s, n, u, d) {
    this.roomName = roomName;
    this.desc = desc;
    this.id = id;
    this.e = e;
    this.w = w;
    this.s = s;
    this.n = n;
    this.u = u;
    this.d = d;

    this.displayRoomInfo = function () {
        t();
        tv("// [" + this.roomName + "] "+ this.desc);
        // tv(this.desc);
        tv(this.getRoomEnter());
    }

    this.getRoomEnter = function () {
        var enters = "이동 범위 : [";
        if (e != 0) {
            enters = enters + " 동";
        }
        if (w != 0) {
            enters = enters + " 서";
        }
        if (s != 0) {
            enters = enters + " 남";
        }
        if (n != 0) {
            enters = enters + " 북";
        }
        if (u != 0) {
            enters = enters + " 위";
        }
        if (d != 0) {
            enters = enters + " 아래";
        }
        enters = enters + " ]";
        return enters;
    }

    //이동 id 변환식
    this.getmoveid = function (moveon) {

        switch (moveon) {
            case "동":
                return this.e;
            case "서":
                return this.w;
            case "남":
                return this.s;
            case "북":
                return this.n;
            case "위":
                return this.u;
            case "아래":
                return this.d;
        }
    }
}