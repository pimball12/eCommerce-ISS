/*

  OKZoom by OKFocus v1.1
  http://okfoc.us // @okfocus
  Copyright 2012 OKFocus
  Licensed under the MIT License

*/
$(function(a) {
    a.fn.okzoom = function(b) {
        return b = a.extend({}, a.fn.okzoom.defaults, b), this.each(function() {
            var c = {},
                d = this;
            c.options = b, c.$el = a(d), c.el = d, c.listener = document.createElement("div"), c.$listener = a(c.listener).addClass("ok-listener").css({
                position: "absolute",
                zIndex: 1e4
            }), a("body").append(c.$listener);
            var e = document.createElement("div");
            if (e.id = "ok-loupe", e.style.position = "absolute", e.style.backgroundRepeat = "no-repeat", e.style.pointerEvents = "none", e.style.display = "none", e.style.zIndex = 7879, a("body").append(e), c.loupe = e, c.$el.data("okzoom", c), c.options = b, a(c.el).bind("mouseover", function(b) {
                    return function(c) {
                        a.fn.okzoom.build(b, c)
                    }
                }(c)), c.$listener.bind("mousemove", function(b) {
                    return function(c) {
                        a.fn.okzoom.mousemove(b, c)
                    }
                }(c)), c.$listener.bind("mouseout", function(b) {
                    return function(c) {
                        a.fn.okzoom.mouseout(b, c)
                    }
                }(c)), c.options.height = c.options.height || c.options.width, c.image_from_data = c.$el.data("okimage"), c.has_data_image = "undefined" != typeof c.image_from_data, c.has_data_image && (c.img = new Image, c.img.src = c.image_from_data), c.msie = -1, "Microsoft Internet Explorer" == navigator.appName) {
                var f = navigator.userAgent,
                    g = new RegExp("MSIE ([0-9]{1,}[.0-9]{0,})");
                null != g.exec(f) && (c.msie = parseFloat(RegExp.$1))
            }
        })
    }, a.fn.okzoom.defaults = {
        width: 150,
        height: null,
        scaleWidth: null,
        round: !0,
        background: "#fff",
        backgroundRepeat: "no-repeat",
        shadow: "0 0 5px #000",
        border: 0
    }, a.fn.okzoom.build = function(b, c) {
        if (b.has_data_image ? b.image_from_data != b.$el.attr("data-okimage") && (b.image_from_data = b.$el.attr("data-okimage"), a(b.img).remove(), b.img = new Image, b.img.src = b.image_from_data) : b.img = b.el, b.msie > -1 && b.msie < 9 && !b.img.naturalized) {
            var d = function(a) {
                a = a || this;
                var b = new Image;
                b.el = a, b.src = a.src, a.naturalWidth = b.width, a.naturalHeight = b.height, a.naturalized = !0
            };
            if (!b.img.complete) return;
            d(b.img)
        }
        b.offset = b.$el.offset(), b.width = b.$el.width(), b.height = b.$el.height(), b.$listener.css({
            display: "block",
            width: b.$el.outerWidth(),
            height: b.$el.outerHeight(),
            top: b.$el.offset().top,
            left: b.$el.offset().left
        }), b.options.scaleWidth ? (b.naturalWidth = b.options.scaleWidth, b.naturalHeight = Math.round(b.img.naturalHeight * b.options.scaleWidth / b.img.naturalWidth)) : (b.naturalWidth = b.img.naturalWidth, b.naturalHeight = b.img.naturalHeight), b.widthRatio = b.naturalWidth / b.width, b.heightRatio = b.naturalHeight / b.height, b.loupe.style.width = b.options.width + "px", b.loupe.style.height = b.options.height + "px", b.loupe.style.border = b.options.border, b.loupe.style.background = b.options.background + " url(" + b.img.src + ")", b.loupe.style.backgroundRepeat = b.options.backgroundRepeat, b.loupe.style.backgroundSize = b.options.scaleWidth ? b.naturalWidth + "px " + b.naturalHeight + "px" : "auto", b.loupe.style.borderRadius = b.loupe.style.OBorderRadius = b.loupe.style.MozBorderRadius = b.loupe.style.WebkitBorderRadius = b.options.round ? b.options.width + "px" : 0, b.loupe.style.boxShadow = b.options.shadow, b.initialized = !0, a.fn.okzoom.mousemove(b, c)
    }, a.fn.okzoom.mousemove = function(a, b) {
        if (a.initialized) {
            var c = a.options.width / 2,
                d = a.options.height / 2,
                e = "undefined" != typeof b.pageX ? b.pageX : b.clientX + document.documentElement.scrollLeft,
                f = "undefined" != typeof b.pageY ? b.pageY : b.clientY + document.documentElement.scrollTop,
                g = -1 * Math.floor((e - a.offset.left) * a.widthRatio - c),
                h = -1 * Math.floor((f - a.offset.top) * a.heightRatio - d);
            document.body.style.cursor = "none", a.loupe.style.display = "block", a.loupe.style.left = e - c + "px", a.loupe.style.top = f - d + "px", a.loupe.style.backgroundPosition = g + "px " + h + "px"
        }
    }, a.fn.okzoom.mouseout = function(a) {
        a.loupe.style.display = "none", a.loupe.style.background = "none", a.listener.style.display = "none", document.body.style.cursor = "auto"
    }
});