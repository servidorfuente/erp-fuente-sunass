function extenderScheduleWeek() {
	this.cfg = $.extend(true, this.cfg, {
		views : {
			week : {
				titleFormat : 'DD/MMMM/YYYY',
				columnFormat : 'dddd',
				timeFormat : '(HH:mm)',
				displayEventEnd : true
			}
		},
		axisFormat : 'HH:mm - HH:59',
		firstDay: 1
	});
}